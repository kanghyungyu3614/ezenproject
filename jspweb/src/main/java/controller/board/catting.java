package controller.board;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Hashtable;

import javax.websocket.*;

@ServerEndpoint("/chatting/{mid}")
public class catting{
	// 0. 접속명단 [ 세션=클라이언소켓 , 아이디 ] = map 
	public static Hashtable< Session , String > clients = new Hashtable<>();
	// 1. 접속
	@OnOpen	// 웹소켓이 들어왔을때 
	public void OnOpen( Session session , @PathParam("mid") String mid  ) {
		clients.put(session, mid);
	}
	// 2. 나가기 
	@OnClose // 웹소켓을 나갔을때 
	public void onClose( Session session ) {
		clients.remove(session);
	}
	// 3. 메시지 받기
	@OnMessage // 웹소켓에 메시지 왔을때 
	public void onMessage( Session session , String msg ) throws IOException {
		for( Session s : clients.keySet() ) {
			s.getBasicRemote().sendText(msg);
		}
	}
}





