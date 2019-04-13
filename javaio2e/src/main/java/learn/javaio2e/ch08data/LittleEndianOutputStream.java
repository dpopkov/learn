package learn.javaio2e.ch08data;

import java.io.*;

public class LittleEndianOutputStream extends FilterOutputStream implements DataOutput {
    protected int written;

    public LittleEndianOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
        written++;
    }

    @Override
    public void write(byte[] data, int off, int len) throws IOException {
        out.write(data, off, len);
        written += len;
    }

    @Override
    public void writeBoolean(boolean b) throws IOException {
        this.write(b ? 1 : 0);
    }

    @Override
    public void writeByte(int b) throws IOException {
        out.write(b);
        written++;
    }

    @Override
    public void writeShort(int v) throws IOException {
        out.write(v & 0xFF);
        out.write((v >>> 8) & 0xFF);
        written += 2;
    }

    @Override
    public void writeChar(int v) throws IOException {
        out.write(v & 0xFF);
        out.write((v >>> 8) & 0xFF);
        written += 2;
    }

    @Override
    public void writeInt(int v) throws IOException {
        out.write(v & 0xFF);
        out.write((v >>> 8) & 0xFF);
        out.write((v >>> 16) & 0xFF);
        out.write((v >>> 24) & 0xFF);
        written += 4;
    }

    @Override
    public void writeLong(long v) throws IOException {
        out.write((int)v & 0xFF);
        out.write((int)(v >>> 8) & 0xFF);
        out.write((int)(v >>> 16) & 0xFF);
        out.write((int)(v >>> 24) & 0xFF);
        out.write((int)(v >>> 32) & 0xFF);
        out.write((int)(v >>> 40) & 0xFF);
        out.write((int)(v >>> 48) & 0xFF);
        out.write((int)(v >>> 56) & 0xFF);
        written += 8;
    }

    @Override
    public void writeFloat(float v) throws IOException {
        this.writeInt(Float.floatToIntBits(v));
    }

    @Override
    public void writeDouble(double v) throws IOException {
        this.writeLong(Double.doubleToLongBits(v));
    }

    @Override
    public void writeBytes(String s) throws IOException {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            out.write(s.charAt(i));
        }
        written += length;
    }

    @Override
    public void writeChars(String s) throws IOException {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            out.write(ch & 0xFF);
            out.write((ch >>> 8) & 0xFF);
        }
        written += 2 * length;
    }

    @Override
    public void writeUTF(String s) throws IOException {
        int numChars = s.length();
        int numBytes = 0;
        for (int i = 0 ; i < numChars ; i++) {
            int c = s.charAt(i);
            if ((c >= 0x0001) && (c <= 0x007F)) numBytes++;
            else if (c > 0x07FF) numBytes += 3;
            else numBytes += 2;
        }
        if (numBytes > 65535) throw new UTFDataFormatException( );
        out.write((numBytes >>> 8) & 0xFF);
        out.write(numBytes & 0xFF);
        for (int i = 0 ; i < numChars ; i++) {
            int c = s.charAt(i);
            if ((c >= 0x0001) && (c <= 0x007F)) {
                out.write(c);
            }
            else if (c > 0x07FF) {
                out.write(0xE0 | ((c >> 12) & 0x0F));
                out.write(0x80 | ((c >>  6) & 0x3F));
                out.write(0x80 | (c & 0x3F));
                written += 2;
            }
            else {
                out.write(0xC0 | ((c >>  6) & 0x1F));
                out.write(0x80 | (c & 0x3F));
                written += 1;
            }
        }
        written += numChars + 2;
    }

    public int size() {
        return this.written;
    }
}
