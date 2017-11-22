(defproject cljs-test-dom-report-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}



  :min-lein-version "2.7.1"

  :dependencies [[org.clojure/clojure "1.9.0-beta4"]
                 [org.clojure/clojurescript "1.9.946"]
                 [org.clojure/core.async  "0.3.443"]]

  :plugins [[lein-figwheel "0.5.14"]
            [lein-cljsbuild "1.1.7" :exclusions [[org.clojure/clojure]]]

            ;; <++++++++++++++++++
            [lein-doo "0.1.8"]
            ;; +++++++++++++++++++>
            ]

  :source-paths ["src"]

  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]
                :figwheel {:on-jsload "cljs-test-dom-report-demo.core/on-js-reload"
                           :open-urls ["http://localhost:3449/index.html"]}

                :compiler {:main cljs-test-dom-report-demo.core
                           :asset-path "js/compiled/out"
                           :output-to "resources/public/js/compiled/cljs_test_dom_report_demo.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true
                           :preloads [devtools.preload]}}
               {:id "min"
                :source-paths ["src"]
                :compiler {:output-to "resources/public/js/compiled/cljs_test_dom_report_demo.js"
                           :main cljs-test-dom-report-demo.core
                           :optimizations :advanced
                           :pretty-print false}}

               ;; <++++++++++++++++++
               {:id           "test"
                :source-paths ["src" "test" "test-doo"]
                :compiler     {:main          cljs-test-dom-report-demo.runner-doo
                               :output-to     "resources/public/js/compiled/test/test.js"
                               :output-dir    "resources/public/js/compiled/test/test/out"
                               :optimizations :none}}

               {:id           "test-live"
                :source-paths ["src" "test"]
                :figwheel {:on-jsload "cljs-test-dom-report-demo.runner/run"
                           :open-urls ["http://localhost:3449/tests.html"]}
                :compiler     {:main          cljs-test-dom-report-demo.runner-live
                               :output-to     "resources/public/js/compiled/test-live/test.js"
                               :output-dir    "resources/public/js/compiled/test-live/out"
                               :asset-path    "js/compiled/test-live/out"
                               :source-map-timestamp true}}
               ;; +++++++++++++++++++>

               ]}

  :figwheel {:css-dirs ["resources/public/css"]}


  :profiles {:dev {:dependencies [[binaryage/devtools "0.9.4"]
                                  [figwheel-sidecar "0.5.14"]
                                  [com.cemerick/piggieback "0.2.2"]
                                  ;; <++++++++++++++++++
                                  [com.zimpler/cljs-test-dom-report "0.1.0-SNAPSHOT"]
                                  ;; +++++++++++++++++++>
                                  ]
                   :source-paths ["src" "dev"]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
                   :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                                     :target-path]}})
