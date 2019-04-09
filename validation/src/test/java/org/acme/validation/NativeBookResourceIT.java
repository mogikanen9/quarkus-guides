package org.acme.validation;

import io.quarkus.test.junit.SubstrateTest;

@SubstrateTest
public class NativeBookResourceIT extends BookResourceTest {

    // Execute the same tests but in native mode.
}