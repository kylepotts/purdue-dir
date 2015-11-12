(ns purduedir.core
  (:require [net.cgrand.enlive-html :as html]
            [clojure.data.json :as json])
  (import [java.net URLEncoder])
  (:gen-class))

(defn createBasicSearchUrl
  [searchString]
  (str "https://www.purdue.edu/directory?SearchString=" (URLEncoder/encode searchString "UTF-8")))

(defn fetch-url 
  [url]
  (html/html-resource (java.net.URL. url)))

;; given a table row get all the text from the table header and table data put them in a map
(defn getRowContent 
  [row]
  (let [header (map html/text (html/select row [:th])) data (map html/text (html/select row [:td]))]
    {:header (apply str header) :data (apply str data)}))

;;  apply getRowContnet to to each table row
(defn handle-table-rows
  [row]
  (let [content (html/select row [:tr])]
    (map getRowContent content)))

(defn getSearchError
  [content]
  (let [result (apply str (map html/text (html/select content [:section [:p]])))]
    (clojure.string/replace result #"\(|\)" "")))

;; get the HTML from the search page
(defn getTable
  [searchString]
  (let [content (fetch-url (createBasicSearchUrl searchString))  table (html/select content [:table.more])]
    (if (not= (count table) 0 ) {:success true :data table} {:sucess false :data (getSearchError content)})))


(defn queryDirectory
  [name]
  (let [table (getTable name) foundTable (:sucess table) data (:data table)]
    (if (= false foundTable) table {:sucess true :data (map handle-table-rows data) } )))

(defn queryDirectoryJson
  [name]
  (json/write-str (queryDirectory name)))
                                         
                                         
                                         
                                         