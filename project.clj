(defproject yuggoth "0.5.0-SNAPSHOT"

  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :dependencies
  [[org.clojure/clojure "1.6.0"]
   [lib-noir "0.8.4"]
   [compojure "1.1.8"]
   [ring-server "0.3.1"]
   [clavatar "0.2.1"]
   [clj-rss "0.1.8"]
   [com.taoensso/timbre "3.2.1"]
   [net.sf.jlue/jlue-core "1.3"]
   [org.clojure/java.jdbc "0.3.4"]
   [postgresql/postgresql "9.1-901-1.jdbc4"]
   [environ "0.5.0"]
   [selmer "0.6.9"]
   [org.clojure/clojurescript "0.0-2268"]
   [reagent "0.4.2"]
   [secretary "1.2.0"]
   [cljs-ajax "0.2.6"]
   [com.andrewmcveigh/cljs-time "0.1.5"]]

  :ring
  {:handler yuggoth.handler/app,
   :init yuggoth.handler/init}

  :cljsbuild
 {:builds
  [{:id "dev"
    :source-paths ["src-cljs"]
    :compiler
    {:optimizations :none
     :output-to "resources/public/js/app.js"
     :output-dir "resources/public/js/"
     :pretty-print true
     :source-map true}}
   {:id "release"
    :source-paths ["src-cljs"]
    :compiler
    {:output-to "resources/public/js/app.js"
     :optimizations :advanced
     :pretty-print false
     :output-wrapper false
     :closure-warnings {:non-standard-jsdoc :off}}}]}

  :profiles
  {:production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"]
                   [lein-environ "0.5.0"]
                   [ring/ring-devel "1.3.0"]]
    :env {:dev true}}}

  :minify-assets
{:assets
  {"resources/public/css/site.min.css" "resources/public/css"}}

  :plugins [[lein-ring "0.8.3"]
            [lein-environ "0.5.0"]
            [lein-cljsbuild "1.0.3"]
            [lein-ancient "0.5.0"]
            [lein-asset-minifier "0.1.5"]
            [lein-cooper "0.0.1"]]
  :min-lein-version "2.0.0")
