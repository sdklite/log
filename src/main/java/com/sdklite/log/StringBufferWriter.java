package com.sdklite.log;

import java.io.IOException;
import java.io.Writer;

class StringBufferWriter extends Writer {

    private final StringBuffer buffer;

    public StringBufferWriter(final StringBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void write(final char[] cbuf, final int off, final int len) throws IOException {
        this.buffer.append(cbuf, off, len);
    }

    @Override
    public void flush() throws IOException {
    }

    @Override
    public void close() throws IOException {
    }

    public StringBuffer getStringBuffer() {
        return this.buffer;
    }
    
    @Override
    public String toString() {
        return this.buffer.toString();
    }

}
