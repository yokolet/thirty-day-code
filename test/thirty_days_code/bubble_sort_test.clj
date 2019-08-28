(ns thirty-days-code.bubble-sort-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [thirty-days-code.core-test :as core-test]
            [thirty-days-code.bubble-sort :refer :all]))

(def expected-1 "Array is sorted in 0 swaps.\nFirst Element: 1\nLast Element: 3\n")
(deftest bubble-sort-test-1
  (testing "given already sorted array returns 0 swaps"
    (with-open [rdr (io/reader (io/resource "test-data/bubble-sort-1.txt"))]
      (binding [*in* rdr]
        (let [result (with-out-str (bubble-sort))]
          (is (= expected-1 result)))))))

(def expected-2 "Array is sorted in 3 swaps.\nFirst Element: 1\nLast Element: 3\n")
(deftest bubble-sort-test-2
  (testing "given already sorted array returns 3 swaps"
    (with-open [rdr (io/reader (io/resource "test-data/bubble-sort-2.txt"))]
      (binding [*in* rdr]
        (let [result (with-out-str (bubble-sort))]
          (is (= expected-2 result)))))))

(run-tests)
