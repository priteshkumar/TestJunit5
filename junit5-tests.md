### Junit5 testclass info

`Test class` : any top level class/static member class/@Nested class

> Test class should not be abstract and should have a single constructor


`Test methods` : any instance methods annotated with @Test , @RepeatedTest, @ParameterizedTest, @TestFactory, or @TestTemplate


> Test methods must not return any value and cannot be private or abstract


`Lifecycle methods` : methods annotated with @BeforeAll, @AfterAll, @BeforeEach, or @AfterEach

`@BeforeAll annotated static method`: does initial setup (e.g. database connection etc) before all the tests are run.

`@AfterAll annotated static method` : does cleanup (closing db connection etc) after all tests are run.

`@BeforeEach` : does some initialization before every test runs.

`@AfterEach` : does  cleanup after every test is run.


### Test Instance Lifecycle

> For each test case a new testclass is instantiated to allow isolated execution

> Above is default behavior in Junit Jupiter

>To use same test class instance with all test cases , use below annotation on testclass

`@TestInstance(Lifecycle.PER_CLASS)` : This ensures a single testclass instance for all testcases
