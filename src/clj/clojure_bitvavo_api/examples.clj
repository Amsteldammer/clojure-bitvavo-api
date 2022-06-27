(ns clojure-bitvavo-api.examples
  (:require [cheshire.core :as cheshire]
            [clojure-bitvavo-api.dataparse :as dataparse]))



 (require '[clojure.reflect :as r])
 (use '[clojure.pprint :only [print-table]])
 ;; to help inspect class in clojure.

 (import [com.bitvavo.api Bitvavo])

 ;; (print-table
 ;;   (sort-by :name
 ;;            (filter :exception-types (:members (r/reflect Bitvavo)))))
 (import [org.json JSONObject])
 (import [com.bitvavo.api KeepAliveThread])
 (import [com.bitvavo.api WebsocketClientEndpoint])
 (import [com.bitvavo.api WebsocketSendThread])
 (import [com.bitvavo.api.example example])
 ;; ^ import classes from bitvavo java api.


 ;; swap <APIKEY> and <APISECRET> for actual Bitvavo apikey & apisecret.
 (def auth-string (str "{"
                       "APIKEY: '<APIKEY>', "
                       "APISECRET: '<APISECRET>', ""RESTURL: 'https://api.bitvavo.com/v2',"
                       "WSURL: 'wss://ws.bitvavo.com/v2/',"
                       "ACCESSWINDOW: 10000, "
                       "DEBUGGING: false }"))

 ;;(new JSONObject auth-string)
(def bitvavo-instance (dataparse/bitvavo-inst-from-auth auth-string))

;;(def bitvavo-instance (new Bitvavo (dataparse/string->jsonobj auth-string)))

(defn get-remaining-call-limit []
  (. bitvavo-instance getRemainingLimit))

(defn get-assets-traded []
  (. bitvavo-instance assets (new JSONObject))) ;; get assets traded.

(defn get-1hr-candlesticks-BTC-EUR []
  (. bitvavo-instance candles "BTC-EUR", "1h" (new JSONObject)))

(defn get-15min-candlesticks-BTC-EUR []
  (. bitvavo-instance candles "BTC-EUR", "15m" (new JSONObject)))
;; (. bitvavo-instance candles "BTC-EUR", "1m" (new JSONObject))

(defn get-1hr-BTC-EUR-nice []
  "you use cheshire lib to parse the JSON into something more idiomatic."
  (cheshire/parse-string (. (. bitvavo-instance candles "BTC-EUR", "1h" (new JSONObject)) toString)))

(defn get-1hr-BTC-EUR-from-to []
  "You may also want to fetch data for a range of dates.
   To do this you have to specify start and end timestamps.
   Please note timestamps refer to unix time in ms."
  (cheshire/parse-string
    (.
      (. bitvavo-instance candles "BTC-EUR"
         "1h"
         (new JSONObject
              "{start: 1538774000000, end: 1656329690000}" ))
      toString)))

