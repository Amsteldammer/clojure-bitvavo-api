(ns clojure-bitvavo-api.core
  (:require [cheshire.core :as cheshire])
  (:gen-class))

;(require '[cheshire.core :as json])

(require '[clojure.reflect :as r])
;(require '[org.json :refer :all])
(use '[clojure.pprint :only [print-table]])
;; to help inspect class in clojure.

(import [com.bitvavo.api Bitvavo])
(import [org.json JSONObject])
(import [com.bitvavo.api KeepAliveThread])
(import [com.bitvavo.api WebsocketClientEndpoint])
(import [com.bitvavo.api WebsocketSendThread])
(import [com.bitvavo.api.example example])
;; import classes from bitvavo java api.






















; we do not need a main function for a library.
;(defn -main
;  "I don't do a whole lot ... yet."
;  [& args]
;  (println "Hello, World!"))



