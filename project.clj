(defproject clojure-bitvavo-api "0.1.0-SNAPSHOT"
  :description "A wrapper library for Bitvavo Java api, to make it play nice with Clojure."
  :url "https://github.com/Amsteldammer/clojure-bitvavo-api"
  :license {:name "ISC WITH Classpath-exception-2.0"
            :url "https://opensource.org/licenses/ISC"}
  :dependencies [[org.clojure/clojure "1.10.1"]

                 [junit/junit "4.13.1"]
                 [org.json/json "20180130"]
                 [commons-io/commons-io "2.6"]
                 [commons-codec/commons-codec "1.11"]
                 [org.eclipse.jetty.websocket/javax-websocket-client-impl "9.4.14.v20181114"]
                 [cheshire "5.11.0"]]
  :main ^:skip-aot clojure-bitvavo-api.core
  :source-paths ["src/clj"]     ;; added to enable java code incl.
  :java-source-paths ["src/java"]   ;; added to enable java code incl.
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
