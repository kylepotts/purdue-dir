(defproject purduedir "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [enlive "1.1.6"]
                 [org.clojure/data.json "0.2.6"]
                 [ring "1.4.0"]
                 [compojure "1.4.0"]
                 [environ "1.0.1"]]
  :javac-options ["-target" "1.6" "-source" "1.6" "-Xlint:-options"]
  :plugins [[lein-ring "0.9.7"]
            [lein-environ "1.0.1"]]
  :aot [purduedir.core]
  :min-lein-version "2.0.0"
  :ring {:handler purduedir.server/app})
