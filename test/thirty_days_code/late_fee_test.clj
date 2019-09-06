(ns thirty-days-code.late-fee-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [thirty-days-code.late-fee :refer :all]))

(def expected "45\n")
(deftest late-fee-test
  (testing "given actual and expected dates, find an amount of late fee if it needs"
    (with-open [rdr (io/reader (io/resource "test-data/late-fee.txt"))]
      (binding [*in* rdr]
        (let [result (with-out-str (late-fee))]
          (is (= expected result)))))))

(def expected-2 "0\n")
(deftest late-fee-test-2
  (testing "given actual and expected dates, find an amount of late fee if it needs"
    (with-open [rdr (io/reader (io/resource "test-data/late-fee-2.txt"))]
      (binding [*in* rdr]
        (let [result (with-out-str (late-fee))]
          (is (= expected-2 result)))))))

(run-tests)
