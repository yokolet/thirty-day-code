(ns thirty-days-code.phone-number-test
  (:require [clojure.test :refer :all]
            [thirty-days-code.core-test :as core-test]
            [thirty-days-code.phone-number :refer :all]))

(defn phone-number-test-fixture [f]
  (core-test/wrap-test "test-data/phone-number.txt" f))
(use-fixtures :once phone-number-test-fixture)

(def expected "sam=99912222\nNot found\nharry=12299933\n")
(deftest phone-number-test
  (testing "given a name should find a phone number"
    (let [result (with-out-str (phone-number))]
      (is (= expected result)))))

(run-tests)

