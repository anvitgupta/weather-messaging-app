(ns asgnx.forecast
  (:require [clojure.string :as string]
            [clj-http.client :as client]
            [clojure.data.json :as json]
            [asgnx.http :as http]
            [clojure.core.async :as async :refer [go chan <! >!]]
            [asgnx.kvstore :as kvstore
             :refer [put! get! list! remove!]]))

;; grabs global variable called OPENWEATHERMAPID which holds the api key
;; to access the openweathermap api. If you don't have a api key, register
;; on openweathermap.com for free and once you have received the key, type in
;; the following command => export OPENWEATHERMAPID="your-hexadecimal-key-goes-here"
;; in to your terminal
(def appid (System/getenv "OPENWEATHERMAPID"))

;; api endpoint to be hit by request
(def api-endpoint "http://api.openweathermap.org/data/2.5/forecast")

;; sends api request to endpoint and captures body of the response as a JSON
(defn GET-response [city]
   ((client/get api-endpoint
                   {:query-params {:q city :appid appid}
                    :as :string}) :body))

;; converts JSON object to a map using the JSON library
(defn weather-map [city]
  (json/read-str (GET-response city) :key-fn keyword))

;; converts kelvin input to fahrenheit
(defn kelvin->fahrenheit [kelvin]
  (int (/ (+ (* (- kelvin 273.15) 1.8) 32) 1)))

;; takes each entry (a total of 40) in the weather-map (see method)
;; and pulls the time value, temperature value, and weather description
;; value and joins into a single string that is returned to the user
(try
  (defn get-forecast [city]
    (string/join "\n"
     (for [x (:list (weather-map city))]
      (str
       "Time: "
       (:dt_txt x)
       " Temp: "
       (str (kelvin->fahrenheit (get-in x [:main :temp])))
       "F Weather: "
       (:description (first (:weather x)))))))
  (catch Exception e (str "Caught Exception: " (.getMessage e))))

;; Attempted use http library because of compatability issues with AWS but could not
;; figure out a way to handle promise as any function applied to a promise is another promise.

;   (defn my-handler [response]
;       (let [body   (:body response)
;              status (:status response)]
;           (if (= 200 status
;                (println "got: " body)
;                (println "error: " response))))))
;
; (http/send-get (str "http://api.openweathermap.org/data/2.5/forecast?q=London,us&appid=" appid) my-handler)
