(ns asgnx.forecast-test
  (:require [clojure.test :refer :all]
            [clojure.core.async :refer [<!!]]
            [clojure.spec.alpha :as s]
            [clojure.string :as string]
            [clojure.spec.test.alpha :as stest]
            [clojure.test.check.generators :as gen]
            [asgnx.forecast :refer :all]
            [asgnx.kvstore :as kvstore :refer [put! get!]]))

(def sample-weather-map
  (weather-map "London"))

(deftest weather-map-and-GET-response
  (testing "api call returns 200 and that map is correctly produced from JSON object"
    (is (= "200" (:cod sample-weather-map)))
    (is (= "40" (str (:cnt sample-weather-map))))
    (is (= "London" (get-in sample-weather-map [:city :name])))
    (is (= "GB" (get-in sample-weather-map [:city :country])))
    (is (= "1000000" (get-in sample-weather-map [:city :population])))
    (is (= true (contains? sample-weather-map) :list))))

(deftest kelvin->fahrenheit-test
  (testing "that given a temperature in kelvin, a the temperature in fahrenheit is outputted"
    (is (= -460 (kelvin->fahrenheit 0)))
    (is (= -400 (kelvin->fahrenheit 33)))
    (is (= 0 (kelvin->fahrenheit 255)))
    (is (= 100 (kelvin->fahrenheit 311)))
    (is (= 234 (kelvin->fahrenheit 385)))))


(def sample-forecast
  (get-forecast "London"))

(deftest get-forecast-test
  (testing "that a correctly formmated string outputted when called on"
    (is (= 40 (count (string/split-lines sample-forecast))))
    (is (= true (every? true?
                        (for [x (string/split-lines sample-forecast)]
                          (and (string/includes? x "Time")
                               (string/includes? x "Temp")
                               (string/includes? x "F Weather"))))))))
