(defproject purduedir "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [enlive "1.1.6"]
                 [org.clojure/data.json "0.2.6"]
                 [ring "1.4.0"]
                 [compojure "1.4.0"]]
  :javac-options ["-target" "1.6" "-source" "1.6" "-Xlint:-options"]
  :plugins [[lein-ring "0.9.7"]]
  :aot [purduedir.core]
  :ring {:handler purduedir.server/app})
