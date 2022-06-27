(ns clojure-bitvavo-api.dataparse)

(import [com.bitvavo.api Bitvavo])
;;(import [org.json JSONObject])

 ;;(require '[clojure.reflect :as r])
 ;(require '[org.json :refer :all])
 ;;(use '[clojure.pprint :only [print-table]])
 ;; to help inspect class in clojure.

 ;;(import [com.bitvavo.api Bitvavo])
 ;; (print-table
 ;;   (sort-by :name
 ;;            (filter :exception-types (:members (r/reflect Bitvavo)))))
 (import [org.json JSONObject])
 (import [com.bitvavo.api KeepAliveThread])
 (import [com.bitvavo.api WebsocketClientEndpoint])
 (import [com.bitvavo.api WebsocketSendThread])
 (import [com.bitvavo.api.example example])


 ;;(import [org.json JSONObject])

 (defn convert-string-to-jsonobj [s]
   "Converts string to JSONObject. This is how api keys etc. are
    provided to the Java api code (see java/com.bitvavo.api/example/example.java)."
   (new JSONObject s))

 ;;(def string->jsonobj (memoize conqvert-string-to-jsonobj))

 (defn create-new-bitvavo-inst [auth-str]
   "for a given authentication string: creates a new bitvavo instance."
   (let [new-bitvavo-inst (new Bitvavo (convert-string-to-jsonobj auth-str))
         remaining-limit (. new-bitvavo-inst getRemainingLimit)]
     (if (integer? remaining-limit)
       (do (println "Successful authentication.")
           (println "Remaining limit: " remaining-limit)
           new-bitvavo-inst)
       (throw (Exception. "Failure to connect to Bitvavo using provided json.")))))

 (def bitvavo-inst-from-auth (memoize create-new-bitvavo-inst))
