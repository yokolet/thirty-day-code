(ns thirty-days-code.prime-number-test
  (:require [clojure.test :refer :all]
            [thirty-days-code.core-test :as core-test]
            [thirty-days-code.prime-number :refer :all]))

(defn prime-number-test-fixture [f]
  (core-test/wrap-test "test-data/prime-number-2.txt" f))
(use-fixtures :once prime-number-test-fixture)

(def expected ["Not prime" "Prime" "Prime"])
(def expected-2 ["Prime" "Not prime" "Prime"])
(deftest prime-number-test
  (testing "given an integer n, finds it is prime or not"
    ;; no need to use the first number in the test cases
    (Integer/parseInt (clojure.string/trim (read-line)))
    (doseq [[n e] (map list (line-seq (java.io.BufferedReader. *in*))
                       expected-2)]
      (is (= e (prime-number (Integer/parseInt n)))))
    ))

(run-tests)

