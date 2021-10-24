# core-java-functional

| FunctionalInterfaces 	| Parameter 	| Return Type 	| Single Abstract Method 	| Example 	|
|----------------------	|-----------	|-------------	|------------------------	|---------	|
| Supplier<T>          	| 0         	| T           	| get                    	|         	|
| Consumer<T>          	| 1(T)      	| void        	| accept                 	|         	|
| BiConsumer<T, U>     	| 2 (T, U)  	| void        	| accept                 	|         	|
| Predicate<T>         	| 1 (T)     	| boolean     	| test                   	|         	|
| BiPredicate<T, U>    	| 2 (T, U)  	| boolean     	| test                   	|         	|
| Function<T, R>       	| 1 (T)     	| R           	| apply                  	|         	|
| BiFunction<T, U, R>  	| 2 (T, U)  	| R           	| apply                  	|         	|
| UnaryOperator<T>     	| 1 (T)     	| T           	| apply                  	|         	|
| BinaryOperator<T>    	| 2 (T, T)  	| T           	| apply                  	|         	|
