package com.sdklite.log;

import java.io.PrintWriter;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

@SuppressWarnings("serial")
class ThrowableFormat extends Format {

    private static final ThrowableFormat INSTANCE = new ThrowableFormat();

    public static final ThrowableFormat getInstance() {
        return INSTANCE;
    }

    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        if (!(obj instanceof Throwable)) {
            throw new IllegalArgumentException("obj is not an instance of Throwable");
        }

        final Throwable t = (Throwable) obj;
        t.printStackTrace(new PrintWriter(new StringBufferWriter(toAppendTo)));
        return toAppendTo;
    }

    @Override
    public Object parseObject(final String source, final ParsePosition pos) {
        throw new UnsupportedOperationException();
    }

}
