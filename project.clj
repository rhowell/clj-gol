(defproject clj-gol "0.1.0-SNAPSHOT"
  :description "Game Of Life written in Clojure"
  :url "https://github.com/rhowell/clj-gol"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:dev {:dependencies [[speclj "3.1.0"]]}}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [speclj "3.1.0"]
                 [speclj-tmux "1.0.0"]]
  :test-paths ["spec"])
