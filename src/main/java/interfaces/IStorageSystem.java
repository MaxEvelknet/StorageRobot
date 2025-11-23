package interfaces;

public interface IStorageSystem{
	public boolean setup();

	public boolean loadNextBox();

	public boolean boxLoaded();

	public IBox scanBox();

	public boolean store(IBox _box, int _position);

	public IBox unstore(int _position);
}