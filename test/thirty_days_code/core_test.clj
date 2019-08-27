(ns thirty-days-code.core-test
  (:require [clojure.java.io :as io]
            [clojure.test :refer :all]))

(defn wrap-test [n f]
  (with-open [rdr (io/reader (io/resource n))]
    (binding [*in* rdr]
      (f))))

