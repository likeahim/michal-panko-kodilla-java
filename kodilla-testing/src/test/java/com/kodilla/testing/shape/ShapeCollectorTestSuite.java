package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("SHAPES TESTS SUITE")
public class ShapeCollectorTestSuite {
    private static int testCounter = 0;
    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Nested
    @DisplayName("Tests for adding and removing")
    class AddRemoveTests {
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            Shape triangle = new Triangle();
            int startSize = collector.getShapes().size();
            //When
            collector.addShape(triangle);
            //Then
            assertNotEquals(collector.getShapes().size(), startSize);
        }

        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            Shape shapeToRemove = new Square();
            collector.addShape(shapeToRemove);
            List<Shape> shapes = collector.getShapes();

            //When
            int size = shapes.size();
            collector.removeShape(shapeToRemove);

            //Then
            assertNotEquals(shapes.size(), size);
        }
    }

    @Nested
    @DisplayName("Tests for getting shape oraz names all shapes")
    class ReturnOrDisplayNamesShapes {
        @Test
        void testGetFigure() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            int indexToGet = 0;
            List<Shape> shapes = collector.getShapes();
            shapes.add(new Circle());

            //When
            Shape shape = collector.getFigure(indexToGet);
            boolean result = (shape instanceof Circle);

            //Then
            assertTrue(result);
        }

        @Test
        void testShowFigures() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            collector.addShape(new Square());
            collector.addShape(new Triangle());
            collector.addShape(new Circle());

            //When
            String result = collector.showFigures();

            //Then
            assertFalse(result.isBlank());
        }
    }
}
