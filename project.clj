(defproject conversely "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [ring/ring-json "0.3.1"]
                 [lib-noir "0.9.5"]
                 [korma "0.4.0"]
                 [crypto-password "0.1.3"]
                 [environ "1.0.0"]
                 [postgresql "9.3-1102.jdbc41"]
                 [clj-time "0.9.0"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler conversely.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
