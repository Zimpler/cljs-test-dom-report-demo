(ns cljs-test-dom-report-demo.runner
  (:require [cljs.test :refer-macros [run-tests]]
            [cljs-test-dom-report-demo.core-test]))

(defn ^:export run []
  (run-tests 'cljs-test-dom-report-demo.core-test))
