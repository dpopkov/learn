/**
 * Covers the unit testing concepts, the JUnit 4 framework and the advanced features of JUnit 4.<br>
 * <br>
 * SanityTest - using {@code @BeforeClass, @Before, @Test, @After, @AfterClass} annotations.<br>
 * AssertTest - verifying test conditions with Assertion.<br>
 * ExceptionTest - working with exception handling.<br>
 * RunWithHowTo - exploring the {@code @RunWith} annotation.<br>
 * IgnoreTest - ignoring a test.<br>
 * ExecutionOrderTest - executing tests in order using {@code @FixMethodOrder} annotation.<br>
 * AssumptionTest - learning assumptions.<br>
 * SuiteTest - exploring the test suite.<br>
 * AssertThatTest - asserting with {@code assertThat}:<br>
 *          compare matchers - {@code equalsTo, is, not},<br>
 *          compound value matchers – {@code either, both, anyOf, allOf, not}<br>
 *          collection matchers – {@code hasItem, hasItems}<br>
 * FactorialParameterizedTest - creating parameterized tests<br>
 * FactorialParameterizedMethodTest - creating parameterized methods<br>
 * TimeoutTest - working with timeouts<br>
 * MyTheorySingleDimensionVariablesTest - exploring JUnit theories for primitive variables<br>
 * MyTheoryArrayTest - exploring JUnit theories for arrays<br>
 * TheoryExternalDataTest - externalizing data using {@code @ParametersSuppliedBy, @ParameterSupplier}<br>
 * Dealing with JUnit rules (all test classes in package 'rules'):<br>
 *          TimeoutRuleTest - the timeout rule applies the same timeout to all the test methods in a class<br>
 *          ExpectedExceptionRuleTest - allows to assert the expected exception type and the exception message<br>
 *          TemporaryFolderRuleTest - allows the creation of files and folders that are guaranteed to be deleted
 *                                    when the test method finishes<br>
 *          ErrorCollectorRuleTest - allows the execution of a test to continue after the first problem is found<br>
 *          VerifierRuleTest - {@code Verifier} rule can turn passing tests into failing tests
 *                              if a verification check fails.<br>
 *          TestWatcherRuleTest - {@code TestWatcher} rule takes note of the testing action, without modifying it.<br>
 *          TestNameRuleTest - {@code TestName} rule makes the current test name available inside test methods<br>
 *
 *          ExternalResourceRuleTest - {@code ExternalResource} rule makes the setup and cleanup work
 *                                      the responsibility of the resource.<br>
 * Exploring Categories (all test classes in package 'categories':<br>
 *          CrazyTestSuite - usage of {@code IncludeCategory} annotation<br>
 *          CrazyTestExclusionSuite - usage of {@code ExcludeCategory} annotation
 *                  - both test classes use {@code Categories} runner.<br>
 */
package learn.mutumju.ch01recall;