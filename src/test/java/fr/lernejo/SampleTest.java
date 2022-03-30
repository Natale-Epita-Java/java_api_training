package fr.lernejo;

import org.junit.jupiter.api.Assertions;


class SampleTest {

    @org.junit.jupiter.api.Test
    void op() {
        Sample unSample = new Sample();
        Assertions.assertEquals(unSample.op(Sample.Operation.ADD, 1, 2), 3);
        Assertions.assertEquals(unSample.op(Sample.Operation.ADD, -15, 15), 0);
        Assertions.assertEquals(unSample.op(Sample.Operation.ADD, -2, -2), -4);
        Assertions.assertEquals(unSample.op(Sample.Operation.ADD, 36, 0), 36);
        Assertions.assertEquals(unSample.op(Sample.Operation.ADD, 0, 0), 0);

        
        Assertions.assertEquals(unSample.op(Sample.Operation.MULT, 1, 2), 2);
        Assertions.assertEquals(unSample.op(Sample.Operation.MULT, -15, 15), -225);
        Assertions.assertEquals(unSample.op(Sample.Operation.MULT, 22, 0), 0);
        Assertions.assertEquals(unSample.op(Sample.Operation.MULT, -2, -2), 4);
        Assertions.assertEquals(unSample.op(Sample.Operation.MULT, 0, 0), 0);
    }

    @org.junit.jupiter.api.Test
    void fact() {
        Sample unSample = new Sample();

        Assertions.assertEquals(unSample.fact(5), 120);
        Assertions.assertEquals(unSample.fact(121), 0);
        Assertions.assertEquals(unSample.fact(1), 1);
        Assertions.assertEquals(unSample.fact(0), 1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> unSample.fact(-5));
    }
}
