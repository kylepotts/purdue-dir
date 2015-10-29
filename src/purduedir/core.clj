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


(defn getContent 
  [row]
  (let [header (map html/text (html/select row [:th])) data (map html/text (html/select row [:td]))]
    {:header (apply str header) :data (apply str data)}))

(defn handle-table-row
  [row]
  (let [content (html/select row [:tr])]
    (map getContent content)))

(defn callDir
  []
  (let [tables (html/select (fetch-url (createURL "Kyle")) [:table])]
        (map handle-table-row tables)))

(defn -main
  [& args]
  (println "Hello, World!"))


