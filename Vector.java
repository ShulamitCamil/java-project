
package Primitives;

public class Vector {
	protected Point3D _head;
	
	//*********************************constructors********************************//
	
	/**
	 * c-tor
	 */
	public Vector(Point3D head) {
		this._head = new Point3D(head);
	}
	
	public Vector (double x, double y, double z)
	
	{
		this._head=new Point3D(x, y, z);

	}
	
	/**
	 * default constructor
	 */
	public Vector() {
		this._head = new Point3D();
	}
	
	/**
	 * copy constructor
	 */
	public Vector(Vector v) {
		this._head = new Point3D(v._head);
	}
	
	/**
	 * @param Point3D p1, Point3D p2, gets 2 points and do subtract 
	 */
	public Vector(Point3D p1, Point3D p2) {//
		double x = p2._x._coordinate - p1._x._coordinate;
		double y = p2._y._coordinate - p1._y._coordinate;
		double z = p2._z._coordinate - p1._z._coordinate;
		_head = new Point3D(x, y, z);
	}
	
	//***************************getters and setters****************************//
	
	/**
	 * @return get_head
	 */
	public Point3D get_head() {
		return new Point3D(_head);
	}
	
	/**
	 * set_head
	 */
	public void set_head(Point3D head) {
		this._head = new Point3D(head);
	}
	
	//****************************administration********************************// 
	
	/**
	 * equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (_head == null) {
			if (other._head != null)
				return false;
		} else if (!_head.equals(other._head))
			return false;
		return true;
	}
	
	/**
	 * to string
	 */
	@Override
	public String toString() {
		return _head.toString();
	}
	
	//***************************operations********************************//
	
	/**
	 * @param Vector vector, add 2 vectors- it calls the function add from point3d
	 */
	public void add(Vector vector)
	{
		_head.add(vector);
	}
	
	/**
	 * @param Vector vector, subtract 2 vectors- it calls the function add from point3d
	 */
	public void subtract (Vector vector)
	{
		_head.subtract(vector);
	}
	
	/**
	 * @param double scalingFacor, multiple the vector with scalingFacor
	 */
	public void scale(double scalingFacor)
	{
		_head._x.set_coordinate(_head._x._coordinate * scalingFacor);
		_head._y.set_coordinate(_head._y._coordinate * scalingFacor);
		_head._z.set_coordinate(_head._z._coordinate * scalingFacor);
	}
	
	/**
	 * @return double, calculates the length of the vector
	 */
	public double length()
	{
		return Math.sqrt(_head._x._coordinate * _head._x._coordinate + _head._y._coordinate*_head._y._coordinate + _head._z._coordinate * _head._z._coordinate);
	}
	
	/**
	 * normalizes the vector-now the length of the vector is 1
	 */
	public void normalize()
	{
		double length = length();
		if (length != 0)
		{
		_head._x.set_coordinate(_head.get_x().get_coordinate()/length);
		_head._y.set_coordinate(_head.get_y().get_coordinate()/length);
		_head._z.set_coordinate(_head.get_z().get_coordinate()/length);
		}
	}
	
	/**
	 * @param Vector v, crossProduct
	 * @return Vector
	 */
	public Vector crossProduct(Vector v)
	{
		double X = (_head._y._coordinate * v._head._z._coordinate - _head._z._coordinate * v._head._y._coordinate);
		double Y = (_head._z._coordinate * v._head._x._coordinate -_head._x._coordinate * v._head._z._coordinate);
		double Z =(_head._x._coordinate * v._head._y._coordinate - _head._y._coordinate * v._head._x._coordinate);
		Point3D p = new Point3D(X,Y,Z);
		return new Vector(p);
	}
	
	/**
	 * @param Vector v, scalar cross
	 * @return double
	 */
	public double dotProduct(Vector v)
	{ 
		return (_head._x._coordinate * v._head._x._coordinate)
				+(_head._y._coordinate * v._head._y._coordinate)
				+(_head._z._coordinate * v._head._z._coordinate);
	}
}


