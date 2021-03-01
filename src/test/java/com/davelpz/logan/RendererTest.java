package com.davelpz.logan;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class RendererTest {

    @Test
    public void render() throws IOException {
        Renderer renderer = new Renderer();
        renderer.render();
    }
}