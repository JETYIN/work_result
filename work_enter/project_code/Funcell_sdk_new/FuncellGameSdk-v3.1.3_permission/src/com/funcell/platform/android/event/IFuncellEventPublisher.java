package com.funcell.platform.android.event;

public abstract interface IFuncellEventPublisher
{
  public abstract void publish(String eventID, Object... params);
}

