(ns clj-gol.router
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [clj-gol.board-generator :as board]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "LIFE!")
  (GET "/next/:state" [state]
    (str "Current state: " (board/generate-state state))))

(def app
  (handler/site app-routes))
