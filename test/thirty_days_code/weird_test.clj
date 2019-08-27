(ns thirty-days-code.weird-test
  (:require [clojure.java.io :as io]
            [clojure.test :refer :all]
            [thirty-days-code.weird :refer :all]))

(deftest weird?-test
  (testing "weird or not weired"
    (is (= "Weird" (weird? 3)))
    (is (= "Not Weird" (weird? 24)))))

(run-tests)

