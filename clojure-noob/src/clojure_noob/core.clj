(ns app.core (:require [io.pedestal.http :as http]
                       [environ.core :refer [env]]))




(defn hello-world [_] {:status 200 :body "Hello"}) ; Route handler
 
(def service-map {::http/routes #{["/" :get hello-world :route-name :hello-world]} ; Routes
             ::http/type   :immutant
             ::http/host   "0.0.0.0"
             ::http/join?  false
             ::http/port   (Integer. (or (env :port) 5000))}) ; Service map
 
(defn -main [_] (-> service-map http/create-server http/start)) ; Server Instance
