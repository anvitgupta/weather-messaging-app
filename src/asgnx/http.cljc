(ns asgnx.http
    #?(:cljs (:require-macros [cljs.core.async.macros :refer [go]]))
    (:require [kvlt.chan :as kvlt]
              [kvlt.core :as kvltc]
              #?(:cljs [clojure.core.async :as async :refer [put! chan <! >! close!]]
                 :clj  [clojure.core.async :as async :refer [go put! chan <! >! close!]])))

(defn disable-logging []
  (kvltc/quiet!))


(defn request [request handler]
    (go
      (try
        (let [response (<! (kvlt.chan/request! request))]
          (handler response))
        #?(:clj  (catch Exception e (do (handler e)))
           :cljs (catch :default e (do (handler e)))))))



(defn send-post
  "Sends an HTTP POST request to the specified url using the supplied map of
   form parameters / values  and invokes the handler
   when a result is received. If the status code does not indicate success,
   the handler will be invoked with an exception map from the underlying
   kvlt library.

   Example:

   (send-post \"https://abcdef.com\"
               {:name \"Bob\"}
               #(println \"Received: \" %))
   "
  [url data handler]
  (request
   {:url         url
    :method      :post
    :headers     {:content-type "application/x-www-form-urlencoded"}
    :form-params data
    :as          :auto}
   handler))


(defn send-get
  "Sends an HTTP GET request to the specified url and invokes the handler
   when a result is received. If the status code does not indicate success,
   the handler will be invoked with an exception map from the underlying
   kvlt library.

   Example:

   (send-get \"https://some-url\"
             #(println \"Received: \" %))
  "
  [url handler]
  (request
   {:url    url
    :method :get}
   handler))
