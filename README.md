# Test Smells Examples

This repository contains examples of common test smells in software testing. Each example is extracted from real-world test cases and demonstrates a specific test smell pattern.

## What are Test Smells?

Test smells are patterns in test code that indicate potential problems in the test suite. They can make tests harder to maintain, less reliable, or less effective at catching bugs.

## Test Smells Included

1. **Assertion Roulette** - Multiple assertions without clear failure messages
2. **Conditional Test Logic** - Tests containing control flow statements that make the test outcome unpredictable
3. **Constructor Initialization** - Using constructors instead of setup methods for test initialization
4. **Default Test** - Using default test classes with example test methods
5. **Duplicate Assert** - Multiple assertions testing the same condition
6. **Eager Test** - Testing multiple behaviors in a single test method
7. **Empty Test** - Test methods with no executable statements
8. **Exception Handling** - Tests that catch exceptions without proper verification
9. **General Fixture** - Test fixtures that are too general and not focused
10. **Ignored Test** - Tests that are disabled or ignored
11. **Lazy Test** - Tests that don't verify all aspects of the behavior
12. **Magic Number Test** - Tests using unexplained numeric literals
13. **Mystery Guest** - Tests that depend on external resources without proper setup
14. **Redundant Print** - Tests containing unnecessary print statements
15. **Redundant Assertion** - Assertions that will always pass
16. **Resource Optimism** - Tests that assume resources are available without verification
17. **Sensitive Equality** - Tests that depend on string representation of objects
18. **Sleepy Test** - Tests that use Thread.sleep() for synchronization
19. **Unknown Test** - Tests without clear assertions or verification

## Source

All examples are extracted from [Test Smells](https://testsmells.org/pages/testsmellexamples.html).

## Usage

Each test smell is demonstrated in its own directory with a Java test file. The examples can be used to:
- Learn about common test smells
- Identify test smells in your own code
- Understand how to improve test quality
- Train developers in test best practices

## Contributing

Feel free to contribute by:
- Adding more examples
- Improving existing examples
- Adding explanations for each test smell
- Suggesting improvements to the documentation 