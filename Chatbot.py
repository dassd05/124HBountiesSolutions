rules = {
    "hello": "Hiya!",
    "how are you": "I'm doing great!",
    "goodbye": "See you later!"
}

def chat_with_bot():
    print("Bot: Hi, I'm a chatbot!")
    while True:
        user_input = input("You: ")
        response = rules.get(user_input, "Sorry, I don't understand that.")
        print(f"Chatbot: {response}")
        if user_input.lower() == 'goodbye':
            break

chat_with_bot()


