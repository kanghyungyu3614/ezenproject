package controller.board;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

//@WebServlet("/chatting")		// 서블릿 URL 만들기
@ServerEndpoint("/chatting/{mid}")	// 웹서버에 웹소켓 URL 만들기 	 URL/{변수명}
public class chatting {
	// 서버소켓 들어온 클라이언소켓 명단 ( 세션 ) vector ---> hashtable  변경한 이유 [ 2개씩 저장할려고 ]
		// arraylist vs Vector [ 동기화x vs 동기화o ]
	public static Hashtable< Session , String > clients = new Hashtable<>();
							// 키[set=중복불가]   :  값 ---> 엔트리  [ 모든 키호출 : clients.keySet() / 값 호출 :  clients.get(키) ]  
	@OnOpen	// 서버소켓이 들어왔을때  [ Session = 클라이언트소켓 = 접속된 유저 ]
	public void OnOpen( Session session , @PathParam("mid") String mid  ) throws IOException { 	// @PathParam(경로상의변수명) : 경로상의 변수 호출 
		clients.put( session , mid); // 접속된 클라이언트소켓을 저장 
		// 접속했다고 다른 사람에게 알리기 
		for( Session s : clients.keySet() ) { // map 저장된 모든 key[ 모든 접속된 클라이언트소켓 세션 ] 호출 [ .keySet() ]
			s.getBasicRemote().sendText( clients.get(s) +"님이 접속 했습니다."  );
										// map.get(키) --> 값 호출 [ mid 호출 ]
		}
	}	
	@OnClose // 서버소켓 을 나갔을때 [ 서버소켓[서버가 재부팅/시작 ] 꺼지나 클라이언트소켓이 닫기 요청했을때 ]
	public void onClose( Session session ) { 
		// 1. 종료된 세션을 접속명단에서 제거
		clients.remove( session ); // map객체명.remove(key) : 해당 key의 엔트리 삭제
	}
	@OnMessage // 서버소켓 에 메시지 왔을때 
	public void onMessage( Session session , String msg ) throws IOException {
		for( Session s : clients.keySet() ) { 	// 접속된 클라이언트 소켓 을 하나씩 호출
			s.getBasicRemote().sendText(msg);
		}
	}
}







