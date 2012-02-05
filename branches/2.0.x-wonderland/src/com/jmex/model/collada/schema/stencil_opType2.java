/**
 * stencil_opType2.java
 *
 * This file was generated by XMLSpy 2007sp2 Enterprise Edition.
 *
 * YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
 * OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION.
 *
 * Refer to the XMLSpy Documentation for further details.
 * http://www.altova.com/xmlspy
 */


package com.jmex.model.collada.schema;


public class stencil_opType2 extends com.jmex.xml.xml.Node {

	public stencil_opType2(stencil_opType2 node) {
		super(node);
	}

	public stencil_opType2(org.w3c.dom.Node node) {
		super(node);
	}

	public stencil_opType2(org.w3c.dom.Document doc) {
		super(doc);
	}

	public stencil_opType2(com.jmex.xml.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	
	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "fail" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "fail", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new failType3(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "zfail" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "zfail", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new zfailType3(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "zpass" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "zpass", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new zpassType3(tmpNode).adjustPrefix();
		}
	}
	public void setXsiType() {
 		org.w3c.dom.Element el = (org.w3c.dom.Element) domNode;
		el.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:type", "stencil_op");
	}

	public static int getfailMinCount() {
		return 1;
	}

	public static int getfailMaxCount() {
		return 1;
	}

	public int getfailCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "fail");
	}

	public boolean hasfail() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "fail");
	}

	public failType3 newfail() {
		return new failType3(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "fail"));
	}

	public failType3 getfailAt(int index) throws Exception {
		return new failType3(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "fail", index));
	}

	public org.w3c.dom.Node getStartingfailCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "fail" );
	}

	public org.w3c.dom.Node getAdvancedfailCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "fail", curNode );
	}

	public failType3 getfailValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new failType3(curNode);
	}

	public failType3 getfail() throws Exception 
 {
		return getfailAt(0);
	}

	public void removefailAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "fail", index);
	}

	public void removefail() {
		removefailAt(0);
	}

	public org.w3c.dom.Node addfail(failType3 value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "fail", value);
	}

	public void insertfailAt(failType3 value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "fail", index, value);
	}

	public void replacefailAt(failType3 value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "fail", index, value);
	}

	public static int getzfailMinCount() {
		return 1;
	}

	public static int getzfailMaxCount() {
		return 1;
	}

	public int getzfailCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "zfail");
	}

	public boolean haszfail() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "zfail");
	}

	public zfailType3 newzfail() {
		return new zfailType3(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "zfail"));
	}

	public zfailType3 getzfailAt(int index) throws Exception {
		return new zfailType3(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "zfail", index));
	}

	public org.w3c.dom.Node getStartingzfailCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "zfail" );
	}

	public org.w3c.dom.Node getAdvancedzfailCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "zfail", curNode );
	}

	public zfailType3 getzfailValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new zfailType3(curNode);
	}

	public zfailType3 getzfail() throws Exception 
 {
		return getzfailAt(0);
	}

	public void removezfailAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "zfail", index);
	}

	public void removezfail() {
		removezfailAt(0);
	}

	public org.w3c.dom.Node addzfail(zfailType3 value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "zfail", value);
	}

	public void insertzfailAt(zfailType3 value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "zfail", index, value);
	}

	public void replacezfailAt(zfailType3 value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "zfail", index, value);
	}

	public static int getzpassMinCount() {
		return 1;
	}

	public static int getzpassMaxCount() {
		return 1;
	}

	public int getzpassCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "zpass");
	}

	public boolean haszpass() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "zpass");
	}

	public zpassType3 newzpass() {
		return new zpassType3(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "zpass"));
	}

	public zpassType3 getzpassAt(int index) throws Exception {
		return new zpassType3(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "zpass", index));
	}

	public org.w3c.dom.Node getStartingzpassCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "zpass" );
	}

	public org.w3c.dom.Node getAdvancedzpassCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "zpass", curNode );
	}

	public zpassType3 getzpassValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.xml.xml.XmlException("Out of range");
		else
			return new zpassType3(curNode);
	}

	public zpassType3 getzpass() throws Exception 
 {
		return getzpassAt(0);
	}

	public void removezpassAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "zpass", index);
	}

	public void removezpass() {
		removezpassAt(0);
	}

	public org.w3c.dom.Node addzpass(zpassType3 value) {
		return appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "zpass", value);
	}

	public void insertzpassAt(zpassType3 value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "zpass", index, value);
	}

	public void replacezpassAt(zpassType3 value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "zpass", index, value);
	}

}