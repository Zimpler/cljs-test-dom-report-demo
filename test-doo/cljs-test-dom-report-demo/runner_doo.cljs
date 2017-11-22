(ns cljs-test-dom-report-demo.runner-doo
    (:require [doo.runner :refer-macros [doo-all-tests]]
              [cljs-test-dom-report-demo.runner]))

(doo-all-tests #"cljs-test-dom-report-demo.*-test")
