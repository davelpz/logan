package com.davelpz.logan;

import com.davelpz.logan.camera.Camera;
import com.davelpz.logan.canvas.Canvas;
import com.davelpz.logan.color.Color;
import com.davelpz.logan.tuple.Tuple;
import com.davelpz.logan.world.World;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class RendererTest {

    @Test
    public void testRender() {
        World w = World.defaultWorld();
        Camera c = new Camera(11,11,Math.PI/2.0);
        Tuple from = Tuple.point(0,0,-5);
        Tuple to = Tuple.point(0,0,0);
        Tuple up = Tuple.vector(0,1,0);
        c.setTransform(World.view_transform(from,to,up));
        Canvas image = Renderer.render(c,w);
        assertTrue(image.pixelAt(5,5).equals(new Color(0.38066,0.47583,0.2855)));
    }
}