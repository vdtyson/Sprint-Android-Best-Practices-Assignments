# Sprint-Android-Best-Practices

## Build a Reactive mortgage calculator.

## Instructions:

1. To calculate an amortized mortgage payment, you'll need to collect the following information in your UI:
* Purchase price
* Down payment
* Interest Rate
* Loan length
2. Consider the best way to set up your UI to get the right kind of input (i.e., decide between EditText, Spinner, etc for each item). Use RxJava (RxBinding is fine if you want to use it!) to make the UI responsive to a change in the input.
3. You can calculate the payment amount using the formula A = P*r*(1+r)^n/((1+r)^n - 1).
4. Set up an RxJava-based Retrofit client against the random number API described at [https://qrng.anu.edu.au/API/api-demo.php] to retrieve simulated mortgage rates. Get at least two numbers and scale them between reasonable mortgage rates. For example, you might get two numbers and use the higher one as a 30 year fixed rate and the lower one as a 15 year fixed rate. Return these values in your UI either as a guide for the user or directly in your UI widgets.

## Stretch goals
1. Create an amortization table that shows the remaining balance, the total payment, the principal paid, and the interest paid for each month.
2. Polish the UI. Consider using TextInputLayout for any EditText fields.