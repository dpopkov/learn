package learn.javaio2e.ch08data;

import java.io.*;

public class LittleEndianInputStream extends FilterInputStream implements DataInput {
    protected LittleEndianInputStream(InputStream in) {
        super(in);
    }

    @Override
    public boolean readBoolean() throws IOException {
        int bool = in.read();
        if (bool == -1) {
            throw new EOFException();
        }
        return bool != 0;
    }

    @Override
    public byte readByte() throws IOException {
        int b = in.read();
        if (b == -1) {
            throw new EOFException();
        }
        return (byte) b;
    }

    @Override
    public int readUnsignedByte() throws IOException {
        int b = in.read();
        if (b == -1) {
            throw new EOFException();
        }
        return b;
    }

    @Override
    public short readShort() throws IOException {
        int b1 = in.read();
        int b2 = in.read();
        if (b2 == -1) {
            throw new EOFException();
        }
        return (short) (((b2 << 24) >>> 16) + (b1 << 24) >>> 24);
    }

    @Override
    public int readUnsignedShort() throws IOException {
        int b1 = in.read();
        int b2 = in.read();
        if (b2 == -1) {
            throw new EOFException();
        }
        return (((b2 << 24) >>> 16) + (b1 << 24) >>> 24);
    }

    @Override
    public char readChar() throws IOException {
        int b1 = in.read();
        int b2 = in.read();
        if (b2 == -1) {
            throw new EOFException();
        }
        return (char) (((b2 << 24) >>> 16) + (b1 << 24) >>> 24);
    }

    @Override
    public int readInt() throws IOException {
        int b1 = in.read();
        int b2 = in.read();
        int b3 = in.read();
        int b4 = in.read();
        if (b4 == -1) {
            throw new EOFException();
        }
        return (b4 << 24)
                + ((b3 << 24) >>> 8)
                + ((b2 << 24) >>> 16)
                + ((b1 << 24) >>> 24);
    }

    @Override
    public long readLong() throws IOException {
        long byte1 = in.read( );
        long byte2 = in.read( );
        long byte3 = in.read( );
        long byte4 = in.read( );
        long byte5 = in.read( );
        long byte6 = in.read( );
        long byte7 = in.read( );
        long byte8 = in.read( );
        if (byte8 == -1) {
            throw new EOFException( );
        }
        return (byte8 << 56)
                + ((byte7 << 56) >>> 8)
                + ((byte6 << 56) >>> 16)
                + ((byte5 << 56) >>> 24)
                + ((byte4 << 56) >>> 32)
                + ((byte3 << 56) >>> 40)
                + ((byte2 << 56) >>> 48)
                + ((byte1 << 56) >>> 56);
    }

    @Override
    public String readUTF() throws IOException {
        int byte1 = in.read();
        int byte2 = in.read();
        if (byte2 == -1) {
            throw new EOFException();
        }
        int numBytes = (byte1 << 8) + byte2;
        char[] result = new char[numBytes];
        int numRead = 0;
        int numChars = 0;
        while (numRead < numBytes) {
            int c1 = readUnsignedByte();
            int test = c1 >> 4;
            if (test < 8) {
                numRead++;
                result[numChars++] = (char) c1;
            } else if (test == 12 || test == 13) {
                numRead += 2;
                if (numRead > numBytes) {
                    throw new UTFDataFormatException();
                }
                int c2 = readUnsignedByte();
                if ((c2 & 0xC0) != 0x80) {
                    throw new UTFDataFormatException();
                }
                result[numChars++] = (char) (((c1 & 0x1F) << 6) | (c2 & 0x3F));
            } else if (test == 14) { // three bytes
                numRead += 3;
                if (numRead > numBytes) {
                    throw new UTFDataFormatException( );
                }
                int c2 = readUnsignedByte( );
                int c3 = readUnsignedByte( );
                if (((c2 & 0xC0) != 0x80) || ((c3 & 0xC0) != 0x80)) {
                    throw new UTFDataFormatException( );
                }
                result[numChars++] = (char) (((c1 & 0x0F) << 12) | ((c2 & 0x3F) << 6) | (c3 & 0x3F));
            }
            else { // malformed
                throw new UTFDataFormatException( );
            }
        }
        return new String(result, 0, numChars);
    }

    @Override
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(this.readLong());
    }

    @Override
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(this.readInt());
    }

    @Override
    public int skipBytes(int n) throws IOException {
        for (int i = 0; i < n; ) {
            i += (int) skip(n - 1);
        }
        return n;
    }

    @Override
    public void readFully(byte[] b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void readFully(byte[] b, int off, int len) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String readLine() {
        throw new UnsupportedOperationException();
    }
}
