(ns thirty-days-code.hourglass-test
  (:require [clojure.test :refer :all]
            [thirty-days-code.core-test :as core-test]
            [thirty-days-code.hourglass :refer :all]))

(defn hourglass-test-fixture [f]
  (core-test/wrap-test "test-data/hourglass.txt" f))
(def expected "19\n")

(use-fixtures :once hourglass-test-fixture)
(deftest hourglass-test
  (testing "given a name should find a phone number"
    (let [result (with-out-str (hourglass))]
      (is (= expected result)))))

(run-tests)
