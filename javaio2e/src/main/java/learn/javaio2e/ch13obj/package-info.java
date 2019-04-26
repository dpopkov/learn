/**
 * 13-2. SerializableZipFileNot - demonstrates the problem of missing no-argument constructor in superclass.<br>
 * 13-3. SerializableZipFile - demonstrates usage of composition rather than inheritance to make zip file serializable.<br>
 * 13-5. SerializableSingleton - demonstrates usage of readResolve() method to maintain the uniqueness of singleton.<br>
 * 13-6. SerializableList - Demonstrates usage of Externalizable interface - a list
 *                          that can be serialized no matter what it contains.<br>
 * 13-7. Person - demonstrates usage of ObjectInputValidation to check the class invariants.<br>
 * 13-8. SealedPoint - writes an encrypted (using SealedObject) java.awt.Point object into the file.<br>
 * 13-9. UnsealPoint - reads the sealed object from the point.des written by SealedPoint and unseals the object.<br>
 */
package learn.javaio2e.ch13obj;