(defproject clj-gol "0.1.0-SNAPSHOT"
  :description "Game Of Life written in Clojure"
  :url "https://github.com/rhowell/clj-gol"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:dev {:dependencies [[speclj "3.1.0"]
                                  [javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]}}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.2.0"]
                 [ring/ring-json "0.3.1"]
                 [speclj "3.1.0"]
                 [speclj-tmux "1.0.0"]
                 [cheshire "5.3.1"]]
  :plugins      [[speclj "3.1.0"]
                 [lein-ring "0.8.12"]
                 [lein-swank "1.4.5"]
                 [cider/cider-nrepl "0.7.0"]]
  :ring {:handler clj-gol.router/app}
  :test-paths ["spec"])
