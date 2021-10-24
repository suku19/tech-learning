# core-java-functional

| FunctionalInterfaces 	| Parameter 	| Return Type 	| Single Abstract Method 	| Example 	|
|----------------------	|-----------	|-------------	|------------------------	|---------	|
| Supplier<T>          	| 0         	| T           	| get                    	|[Supplier](src/test/java/com/techlearn/lambda/functionalinterface/SupplierUnitTest.java)         	|
| Consumer<T>          	| 1(T)      	| void        	| accept                 	|[Consumer](src/test/java/com/techlearn/lambda/functionalinterface/ConsumerUnitTest.java)         	|
| BiConsumer<T, U>     	| 2 (T, U)  	| void        	| accept                 	|         	|
| Predicate<T>         	| 1 (T)     	| boolean     	| test                   	|[Predicate](src/test/java/com/techlearn/lambda/functionalinterface/PredicateUnitTest.java)         	|
| BiPredicate<T, U>    	| 2 (T, U)  	| boolean     	| test                   	|         	|
| Function<T, R>       	| 1 (T)     	| R           	| apply                  	|[Function](src/test/java/com/techlearn/lambda/functionalinterface/FunctionsUnitTest.java)         	|
| BiFunction<T, U, R>  	| 2 (T, U)  	| R           	| apply                  	|         	|
| UnaryOperator<T>     	| 1 (T)     	| T           	| apply                  	|[Operator](src/test/java/com/techlearn/lambda/functionalinterface/OperatorUnitTest.java)         	|
| BinaryOperator<T>    	| 2 (T, T)  	| T           	| apply                  	|         	|
