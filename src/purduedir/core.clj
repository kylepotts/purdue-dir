(ns purduedir.core
  (:require [net.cgrand.enlive-html :as html])
  (import [java.net URLEncoder])
  (:gen-class))



(defn createURL
  [searchString]
  (str "https://www.purdue.edu/directory?SearchString=" (URLEncoder/encode searchString "UTF-8")))

(defn fetch-url 
  [url]
  (html/html-resource (java.net.URL. url)))


(defn getName
  [row]
  (let [name (map html/text (html/select row [:h2.cn-name]))]
    (apply str name )))

(defn getAlias
  [row]
  (let []
    1))

(defn handle-table-row
  [row]
  (let [name (getName row)]
    (println name)))

(defn -main
  [& args]
  (println "Hello, World!"))


