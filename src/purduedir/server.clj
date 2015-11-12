(ns purduedir.server
    (:use compojure.core)
    (:require [compojure.handler :as handler]
              [compojure.route :as route]
              [purduedir.core :as dirAPI]))

(defn handleBasicSearch 
  [req]
    (let [params (:params req) query (:query params)]
      (dirAPI/queryDirectoryJson query)))

(defroutes app-routes
  (GET "/search" [] handleBasicSearch)
  (route/not-found "Not Found"))


(def app
  (handler/site app-routes))