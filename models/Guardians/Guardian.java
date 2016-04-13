/*
 *  OSSD Asignment 1 - The Chase
 *  Charles Yim - S3570764
 *  Jacob Paris - S3238163
 *  Chen Liu- S3481556
 *  Taison Eady - S3282633
 */

package models.Guardians;

import models.Actor;

public abstract class Guardian extends Actor {

	public Guardian(int x, int y)
	{
		super(x, y);
		// TODO Auto-generated constructor stub
	}
    public abstract int getMoveableCount(int rollCount);

	
}
