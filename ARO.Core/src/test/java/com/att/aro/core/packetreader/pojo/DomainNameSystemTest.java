package com.att.aro.core.packetreader.pojo;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Test;
import org.meanbean.lang.Factory;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;


public class DomainNameSystemTest {
	
	Factory<IPPacket> packetEquivalentFactory = new Factory<IPPacket> () {
		@Override
		public IPPacket create() {
			
			int hdrLen = 16; //Header Length
			char[] data = { 0x47, 0x45, 0x54, 0x20, 0x2f, 0x62, 0x3f, 0x73, 0x3d, 0x37, 0x39, 0x32, 0x36, 0x30, 0x30,
							0x31, 0x34, 0x36, 0x26, 0x5f, 0x52, 0x3d, 0x26, 0x5f, 0x4c, 0x3d, 0x6d, 0x25, 0x30, 0x36, 0x72,
							0x65, 0x66, 0x72, 0x65, 0x73, 0x68, 0x2d, 0x61, 0x6e, 0x6e, 0x6f, 0x75, 0x6e, 0x63, 0x65, 0x6d,
							0x65, 0x6e, 0x74, 0x25, 0x30, 0x31, 0x6c, 0x25, 0x30, 0x36, 0x72, 0x65, 0x66, 0x72, 0x65, 0x73,
							0x68, 0x2d, 0x62, 0x61, 0x6e, 0x6e, 0x65, 0x72, 0x2d, 0x64, 0x69, 0x73, 0x6d, 0x69, 0x73, 0x73,
							0x25, 0x30, 0x32, 0x72, 0x65, 0x66, 0x72, 0x65, 0x73, 0x68, 0x2d, 0x62, 0x61, 0x6e, 0x6e, 0x65,
							0x72, 0x2d, 0x6c, 0x69, 0x6e, 0x65, 0x31, 0x25, 0x30, 0x32, 0x72, 0x65, 0x66, 0x72, 0x65, 0x73,
							0x68, 0x2d, 0x62, 0x61, 0x6e, 0x6e, 0x65, 0x72, 0x2d, 0x6c, 0x69, 0x6e, 0x65, 0x31, 0x25, 0x30,
							0x32, 0x72, 0x65, 0x66, 0x72, 0x65, 0x73, 0x68, 0x2d, 0x62, 0x61, 0x6e, 0x6e, 0x65, 0x72, 0x2d,
							0x77, 0x68, 0x61, 0x74, 0x73, 0x2d, 0x6e, 0x65, 0x77, 0x2d, 0x63, 0x74, 0x61, 0x25, 0x30, 0x38,
							0x6d, 0x25, 0x30, 0x36, 0x67, 0x6c, 0x6f, 0x62, 0x61, 0x6c, 0x2d, 0x6e, 0x61, 0x76, 0x25, 0x30,
							0x31, 0x6c, 0x25, 0x30, 0x36, 0x4c, 0x6f, 0x67, 0x6f, 0x2d, 0x6d, 0x61, 0x69, 0x6e, 0x25, 0x30,
							0x32, 0x53, 0x69, 0x67, 0x6e, 0x75, 0x70, 0x2d, 0x6d, 0x61, 0x69, 0x6e, 0x25, 0x30, 0x32, 0x45,
							0x78, 0x70, 0x6c, 0x6f, 0x72, 0x65, 0x2d, 0x6d, 0x61, 0x69, 0x6e, 0x25, 0x30, 0x32, 0x45, 0x78,
							0x70, 0x6c, 0x6f, 0x72, 0x65, 0x2d, 0x72, 0x65, 0x63, 0x65, 0x6e, 0x74, 0x5f, 0x70, 0x68, 0x6f,
							0x74, 0x6f, 0x73, 0x25, 0x30, 0x32, 0x45, 0x78, 0x70, 0x6c, 0x6f, 0x72, 0x65, 0x2d, 0x74, 0x68,
							0x65, 0x5f, 0x63, 0x6f, 0x6d, 0x6d, 0x6f, 0x6e, 0x73, 0x25, 0x30, 0x32, 0x45, 0x78, 0x70, 0x6c,
							0x6f, 0x72, 0x65, 0x2d, 0x67, 0x65, 0x74, 0x74, 0x79, 0x5f, 0x63, 0x6f, 0x6c, 0x6c, 0x65, 0x63,
							0x74, 0x69, 0x6f, 0x6e, 0x25, 0x30, 0x32, 0x45, 0x78, 0x70, 0x6c, 0x6f, 0x72, 0x65, 0x2d, 0x67,
							0x61, 0x6c, 0x6c, 0x65, 0x72, 0x69, 0x65, 0x73, 0x25, 0x30, 0x32, 0x45, 0x78, 0x70, 0x6c, 0x6f,
							0x72, 0x65, 0x2d, 0x77, 0x6f, 0x72, 0x6c, 0x64, 0x5f, 0x6d, 0x61, 0x70, 0x25, 0x30, 0x32, 0x45,
							0x78, 0x70, 0x6c, 0x6f, 0x72, 0x65, 0x2d, 0x61, 0x70, 0x70, 0x5f, 0x67, 0x61, 0x72, 0x64, 0x65,
							0x6e, 0x25, 0x30, 0x32, 0x45, 0x78, 0x70, 0x6c, 0x6f, 0x72, 0x65, 0x2d, 0x63, 0x61, 0x6d, 0x65,
							0x72, 0x61, 0x5f, 0x66, 0x69, 0x6e, 0x64, 0x65, 0x72, 0x25, 0x30, 0x32, 0x45, 0x78, 0x70, 0x6c,
							0x6f, 0x72, 0x65, 0x2d, 0x66, 0x6c, 0x69, 0x63, 0x6b, 0x72, 0x5f, 0x62, 0x6c, 0x6f, 0x67, 0x25,
							0x30, 0x32, 0x55, 0x70, 0x6c, 0x6f, 0x61, 0x64, 0x2d, 0x6d, 0x61, 0x69, 0x6e, 0x25, 0x30, 0x32,
							0x41, 0x63, 0x63, 0x6f, 0x75, 0x6e, 0x74, 0x2d, 0x73, 0x69, 0x67, 0x6e, 0x5f, 0x69, 0x6e, 0x25,
							0x30, 0x38, 0x6d, 0x25, 0x30, 0x36, 0x70, 0x68, 0x6f, 0x74, 0x6f, 0x2d, 0x63, 0x6f, 0x6e, 0x74,
							0x61, 0x69, 0x6e, 0x65, 0x72, 0x25, 0x30, 0x31, 0x6c, 0x25, 0x30, 0x36, 0x61, 0x63, 0x74, 0x69,
							0x6f, 0x6e, 0x2d, 0x6d, 0x65, 0x6e, 0x75, 0x2d, 0x63, 0x6c, 0x69, 0x63, 0x6b, 0x25, 0x30, 0x32,
							0x25, 0x32, 0x33, 0x25, 0x30, 0x32, 0x25, 0x32, 0x33, 0x63, 0x6f, 0x6d, 0x6d, 0x65, 0x6e, 0x74,
							0x73, 0x25, 0x30, 0x32, 0x73, 0x68, 0x61, 0x72, 0x65, 0x2d, 0x6d, 0x65, 0x6e, 0x75, 0x2d, 0x63,
							0x6c, 0x69, 0x63, 0x6b, 0x25, 0x30, 0x32, 0x70, 0x72, 0x65, 0x76, 0x5f, 0x62, 0x75, 0x74, 0x74,
							0x6f, 0x6e, 0x25, 0x30, 0x32, 0x6c, 0x69, 0x67, 0x68, 0x74, 0x62, 0x6f, 0x78, 0x25, 0x30, 0x32,
							0x6e, 0x65, 0x78, 0x74, 0x5f, 0x62, 0x75, 0x74, 0x74, 0x6f, 0x6e, 0x25, 0x30, 0x38, 0x6d, 0x25,
							0x30, 0x36, 0x63, 0x6f, 0x6d, 0x6d, 0x65, 0x6e, 0x74, 0x73, 0x25, 0x30, 0x31, 0x6c, 0x25, 0x30,
							0x36, 0x25, 0x32, 0x46, 0x70, 0x68, 0x6f, 0x74, 0x6f, 0x73, 0x25, 0x32, 0x46, 0x25, 0x32, 0x46,
							0x25, 0x30, 0x32, 0x25, 0x32, 0x46, 0x68, 0x74, 0x6d, 0x6c, 0x2e, 0x67, 0x6e, 0x65, 0x25, 0x33,
							0x46, 0x74, 0x69, 0x67, 0x68, 0x74, 0x65, 0x6e, 0x25, 0x33, 0x44, 0x30, 0x25, 0x32, 0x36, 0x74,
							0x79, 0x70, 0x65, 0x25, 0x33, 0x44, 0x63, 0x6f, 0x6d, 0x6d, 0x65, 0x6e, 0x74, 0x26, 0x74, 0x3d,
							0x31, 0x33, 0x37, 0x30, 0x33, 0x37, 0x37, 0x34, 0x32, 0x36, 0x26, 0x5f, 0x50, 0x3d, 0x32, 0x2e,
							0x39, 0x2e, 0x34, 0x25, 0x30, 0x35, 0x41, 0x5f, 0x70, 0x6e, 0x25, 0x30, 0x33, 0x25, 0x32, 0x46,
							0x70, 0x68, 0x6f, 0x74, 0x6f, 0x2e, 0x67, 0x6e, 0x65, 0x25, 0x30, 0x34, 0x41, 0x5f, 0x73, 0x69,
							0x64, 0x25, 0x30, 0x33, 0x51, 0x68, 0x49, 0x50, 0x70, 0x41, 0x65, 0x73, 0x30, 0x46, 0x74, 0x69,
							0x25, 0x30, 0x34, 0x5f, 0x77, 0x25, 0x30, 0x33, 0x77, 0x77, 0x77, 0x2e, 0x66, 0x6c, 0x69, 0x63,
							0x6b, 0x72, 0x2e, 0x63, 0x6f, 0x6d, 0x25, 0x32, 0x46, 0x70, 0x68, 0x6f, 0x74, 0x6f, 0x73, 0x25,
							0x32, 0x46, 0x39, 0x32, 0x34, 0x35, 0x37, 0x32, 0x34, 0x32, 0x25, 0x34, 0x30, 0x4e, 0x30, 0x34,
							0x25, 0x32, 0x46, 0x38, 0x34, 0x30, 0x34, 0x30, 0x35, 0x32, 0x39, 0x36, 0x32, 0x25, 0x32, 0x46,
							0x25, 0x30, 0x34, 0x41, 0x5f, 0x25, 0x30, 0x33, 0x31, 0x20, 0x48, 0x54, 0x54, 0x50, 0x2f, 0x31,
							0x2e, 0x31, 0x0d, 0x0a, 0x48, 0x6f, 0x73, 0x74, 0x3a, 0x20, 0x67, 0x65, 0x6f, 0x2e, 0x79, 0x61,
							0x68, 0x6f, 0x6f, 0x2e, 0x63, 0x6f, 0x6d, 0x0d, 0x0a, 0x55, 0x73, 0x65, 0x72, 0x2d, 0x41, 0x67,
							0x65, 0x6e, 0x74, 0x3a, 0x20, 0x4d, 0x6f, 0x7a, 0x69, 0x6c, 0x6c, 0x61, 0x2f, 0x35, 0x2e, 0x30,
							0x20, 0x28, 0x4d, 0x61, 0x63, 0x69, 0x6e, 0x74, 0x6f, 0x73, 0x68, 0x3b, 0x20, 0x49, 0x6e, 0x74,
							0x65, 0x6c, 0x20, 0x4d, 0x61, 0x63, 0x20, 0x4f, 0x53, 0x20, 0x58, 0x20, 0x31, 0x30, 0x5f, 0x38,
							0x5f, 0x33, 0x29, 0x20, 0x41, 0x70, 0x70, 0x6c, 0x65, 0x57, 0x65, 0x62, 0x4b, 0x69, 0x74, 0x2f,
							0x35, 0x33, 0x36, 0x2e, 0x32, 0x39, 0x2e, 0x31, 0x33, 0x20, 0x28, 0x4b, 0x48, 0x54, 0x4d, 0x4c,
							0x2c, 0x20, 0x6c, 0x69, 0x6b, 0x65, 0x20, 0x47, 0x65, 0x63, 0x6b, 0x6f, 0x29, 0x20, 0x56, 0x65,
							0x72, 0x73, 0x69, 0x6f, 0x6e, 0x2f, 0x36, 0x2e, 0x30, 0x2e, 0x34, 0x20, 0x53, 0x61, 0x66, 0x61,
							0x72, 0x69, 0x2f, 0x35, 0x33, 0x36, 0x2e, 0x32, 0x39, 0x2e, 0x31, 0x33, 0x0d, 0x0a, 0x41, 0x63,
							0x63, 0x65, 0x70, 0x74, 0x3a, 0x20, 0x2a, 0x2f, 0x2a, 0x0d, 0x0a, 0x52, 0x65, 0x66, 0x65, 0x72,
							0x65, 0x72, 0x3a, 0x20, 0x68, 0x74, 0x74, 0x70, 0x3a, 0x2f, 0x2f, 0x77, 0x77, 0x77, 0x2e, 0x66,
							0x6c, 0x69, 0x63, 0x6b, 0x72, 0x2e, 0x63, 0x6f, 0x6d, 0x2f, 0x70, 0x68, 0x6f, 0x74, 0x6f, 0x73,
							0x2f, 0x39, 0x32, 0x34, 0x35, 0x37, 0x32, 0x34, 0x32, 0x40, 0x4e, 0x30, 0x34, 0x2f, 0x38, 0x34,
							0x30, 0x34, 0x30, 0x35, 0x32, 0x39, 0x36, 0x32, 0x2f, 0x0d, 0x0a, 0x41, 0x63, 0x63, 0x65, 0x70,
							0x74
					};
		
			long seconds = 1394754475L;
			long microSeconds = 514072L;
			int len = 66;
			IPPacket packet = new IPPacket (seconds, microSeconds, len, hdrLen, null, null, toBytes(data));
			return packet;
		}
		
		private byte[] toBytes(char[] chars) {
			CharBuffer charBuffer = CharBuffer.wrap(chars);
			ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
			byte[] bytes = Arrays.copyOfRange(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
			Arrays.fill(charBuffer.array(), '\u0000'); // clear sensitive data
			Arrays.fill(byteBuffer.array(), (byte) 0); // clear sensitive data
			return bytes;
		}
	};

	@Test
	public void testBoilerPlateCode() {
		// Sample Configuration Builder.
		// Configuration config = new ConfigurationBuilder().ignoreProperty("packet").build();
		// beanTester.addCustomConfiguration(DomainNameSystem.class, config);
		BeanTester beanTester = new BeanTester();
		beanTester.getFactoryCollection().addFactory(IPPacket.class, packetEquivalentFactory);
		beanTester.testBean(DomainNameSystem.class);

		EqualsMethodTester beanEqualsTester = new EqualsMethodTester();
		beanEqualsTester.getFactoryCollection().addFactory(IPPacket.class, packetEquivalentFactory);
		beanEqualsTester.testEqualsMethod(DomainNameSystem.class);
		
		HashCodeMethodTester beanHashCodeTester = new HashCodeMethodTester();
		beanHashCodeTester.getFactoryCollection().addFactory(IPPacket.class, packetEquivalentFactory);
		beanHashCodeTester.testHashCodeMethod(DomainNameSystem.class);
	}

}
